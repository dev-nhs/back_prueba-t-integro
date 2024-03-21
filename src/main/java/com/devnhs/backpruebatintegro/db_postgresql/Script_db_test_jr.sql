
CREATE OR REPLACE FUNCTION "Admision".fn_buscar_paciente(
    _criterio_busqueda integer,
    _tipo_documento_identidad integer,
    _numero_documento character varying(11),
    _apellido_paterno_materno character varying(60),
    _nombres character varying(100)
)
RETURNS TABLE (
	id_paciente integer,
    no_apepat character varying,
    no_apemat character varying,
    no_nombres character varying,
    codigo_ieds character,
    no_docide character varying,
    fl_estado bit,
    fe_nacimiento date
)
AS $$
BEGIN
    IF _criterio_busqueda = 1 THEN
        -- Búsqueda por Tipo de Doc. Identidad y Numero Doc. Identidad
        RETURN QUERY
        SELECT
			p.id_paciente,
            p.no_apepat,
            p.no_apemat,
            p.no_nombres,
            d.codigo_ieds,
            p.no_docide,
            d.fl_estado,
            p.fe_nacimiento
        FROM "Admision".tb_paciente p
        INNER JOIN "Admision".tc_tipo_documento_identidad d ON d.id_tipo_documento_identidad = p.id_tipo_docide
        WHERE p.id_tipo_docide = _tipo_documento_identidad
            AND p.no_docide = _numero_documento;
    ELSE
        -- Búsqueda por Apellidos y Nombres
        RETURN QUERY
        SELECT
			p.id_paciente,
            p.no_apepat,
            p.no_apemat,
            p.no_nombres,
            d.codigo_ieds,
            p.no_docide,
            d.fl_estado,
            p.fe_nacimiento
        FROM "Admision".tb_paciente p
        INNER JOIN "Admision".tc_tipo_documento_identidad d ON d.id_tipo_documento_identidad = p.id_tipo_docide
        WHERE (p.no_apepat || ' ' || p.no_apemat) ILIKE '%' || _apellido_paterno_materno || '%'
            OR (p.no_nombres ILIKE '%' || _nombres || '%');
    END IF;
END;
$$ LANGUAGE plpgsql;



CREATE OR REPLACE FUNCTION "Admision".fn_get_departamentos()
RETURNS TABLE (
    descripcion_departamento VARCHAR,
    codigo_departamento VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT DISTINCT
        u.descripcion_departamento,
        u.codigo_departamento
    FROM "Admision".tc_ubigeo u
    ORDER BY u.descripcion_departamento;
END;
$$;



	
CREATE OR REPLACE FUNCTION "Admision".fn_get_provincias(_departamento VARCHAR)
RETURNS TABLE (
    descripcion_provincia VARCHAR,
    codigo_provincia VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT DISTINCT
        u.descripcion_provincia,
        u.codigo_provincia
    FROM "Admision".tc_ubigeo u WHERE u.codigo_departamento = _departamento
    ORDER BY u.descripcion_provincia;
END;
$$;




CREATE OR REPLACE FUNCTION "Admision".fn_get_distritos(_departamento VARCHAR, _provincia VARCHAR)
RETURNS TABLE (
    descripcion_distrito VARCHAR,
    codigo_distrito VARCHAR
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT DISTINCT
	  u.descripcion_distrito,
	  u.codigo_distrito
	FROM "Admision".tc_ubigeo u
	WHERE u.codigo_departamento = _departamento
	  AND u.codigo_provincia = _provincia
	ORDER BY u.descripcion_distrito;
END;
$$;




CREATE OR REPLACE FUNCTION "Admision".fn_obtener_datos_pacientes()
RETURNS TABLE (
	id_paciente integer,
    no_apepat character varying,
    no_apemat character varying,
    no_nombres character varying,
    codigo_ieds character,
    no_docide character varying,
    fl_estado bit,
    fe_nacimiento date
)
LANGUAGE plpgsql
AS $$
BEGIN
    RETURN QUERY
    SELECT
		p.id_paciente,
        p.no_apepat,
        p.no_apemat,
        p.no_nombres,
        d.codigo_ieds,
        p.no_docide,
        d.fl_estado,
        p.fe_nacimiento
    FROM "Admision".tb_paciente p
    INNER JOIN "Admision".tc_tipo_documento_identidad d ON d.id_tipo_documento_identidad = p.id_tipo_docide;
END;
$$;

