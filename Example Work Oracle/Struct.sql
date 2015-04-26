CREATE TABLE addr_loaded
(
   region1_name     VARCHAR2(255),
   region2_name     VARCHAR2(255),
   city_name        VARCHAR2(255),
   city_area_name   VARCHAR2(255),
   quarter_name     VARCHAR2(255),
   street_name      VARCHAR2(255),
   house_num        VARCHAR2(255)
);
COMMENT ON TABLE  addr_loaded                  IS '����������� ������';
COMMENT ON COLUMN addr_loaded.region1_name     IS '�������';
COMMENT ON COLUMN addr_loaded.region2_name     IS '������';
COMMENT ON COLUMN addr_loaded.city_name        IS '�����';
COMMENT ON COLUMN addr_loaded.city_area_name   IS '���.�����';
COMMENT ON COLUMN addr_loaded.quarter_name     IS '�������';
COMMENT ON COLUMN addr_loaded.street_name      IS '�����';
COMMENT ON COLUMN addr_loaded.house_num        IS '���';

CREATE TABLE addr_ldr
(
  str  VARCHAR2(4000),
  is_loaded NUMBER(1) DEFAULT 0 NOT NULL
);
COMMENT ON TABLE  addr_ldr            IS '����������� ������ �� SQLLoader';
COMMENT ON COLUMN addr_ldr.str        IS '������ ������';
COMMENT ON COLUMN addr_ldr.is_loaded  IS '���������� (1-��;0-���) � ������� addr_loaded';

CREATE TABLE addr_fallout
(
  addr_str   VARCHAR2(4000),
  message    VARCHAR2(255)
);
COMMENT ON TABLE  addr_fallout                 IS '��������� ��� ������������ ������';
COMMENT ON COLUMN addr_fallout.addr_str        IS '������ ������, �������� �������� �� �����';
COMMENT ON COLUMN addr_fallout.message         IS '��������� ������ ��� ��������������';


DELETE FROM addr_loaded
/
