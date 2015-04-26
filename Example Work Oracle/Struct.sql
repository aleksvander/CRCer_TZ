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
COMMENT ON TABLE  addr_loaded                  IS 'Загруженные адреса';
COMMENT ON COLUMN addr_loaded.region1_name     IS 'Область';
COMMENT ON COLUMN addr_loaded.region2_name     IS 'Регион';
COMMENT ON COLUMN addr_loaded.city_name        IS 'Город';
COMMENT ON COLUMN addr_loaded.city_area_name   IS 'Гор.район';
COMMENT ON COLUMN addr_loaded.quarter_name     IS 'Квартал';
COMMENT ON COLUMN addr_loaded.street_name      IS 'Улица';
COMMENT ON COLUMN addr_loaded.house_num        IS 'Дом';

CREATE TABLE addr_ldr
(
  str  VARCHAR2(4000),
  is_loaded NUMBER(1) DEFAULT 0 NOT NULL
);
COMMENT ON TABLE  addr_ldr            IS 'Загруженные адреса из SQLLoader';
COMMENT ON COLUMN addr_ldr.str        IS 'Строка адреса';
COMMENT ON COLUMN addr_ldr.is_loaded  IS 'Загруженно (1-Да;0-нет) в таблицу addr_loaded';

CREATE TABLE addr_fallout
(
  addr_str   VARCHAR2(4000),
  message    VARCHAR2(255)
);
COMMENT ON TABLE  addr_fallout                 IS 'Ошибочные или сомнительные адреса';
COMMENT ON COLUMN addr_fallout.addr_str        IS 'Строка адреса, котороая приходит на входе';
COMMENT ON COLUMN addr_fallout.message         IS 'Сообщение ошибки или предупреждение';


DELETE FROM addr_loaded
/
