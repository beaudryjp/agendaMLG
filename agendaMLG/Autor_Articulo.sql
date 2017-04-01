CREATE TABLE PROVINCIA (ID BIGINT NOT NULL, nombre VARCHAR(255) NOT NULL, PRIMARY KEY (ID))
CREATE TABLE LOCALIDAD (localidad_id BIGINT NOT NULL, nombre VARCHAR(255) NOT NULL, PROVINCIA_ID BIGINT, PRIMARY KEY (localidad_id))
CREATE TABLE PROVINCIA_LOCALIDAD (Provincia_ID BIGINT NOT NULL, localidades_localidad_id BIGINT NOT NULL, PRIMARY KEY (Provincia_ID, localidades_localidad_id))
ALTER TABLE LOCALIDAD ADD CONSTRAINT LCALIDADPRVINCIAID FOREIGN KEY (PROVINCIA_ID) REFERENCES PROVINCIA (ID)
ALTER TABLE PROVINCIA_LOCALIDAD ADD CONSTRAINT PRVNCLCLIDADPrvncD FOREIGN KEY (Provincia_ID) REFERENCES PROVINCIA (ID)
ALTER TABLE PROVINCIA_LOCALIDAD ADD CONSTRAINT PRVNCLlclddslclddd FOREIGN KEY (localidades_localidad_id) REFERENCES LOCALIDAD (localidad_id)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(15), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
