--Очищаем таблицу
TRUNCATE TABLE addr_fallout;

--Тестируем "Выборку данных"
/*	SELECT CONCAT(region1_name, ' - ', CONCAT_WS
		('', region2_name, ' ', city_name, ' ', city_area_name, ' ' , quarter_name, ' '
		) AS result
	FROM addr_loaded WHERE region1_name NOT LIKE '%обл.';
*/

--Переносим переброшенные записи в таблицу add_fallout - провожу валидацию только по Области
INSERT INTO addr_fallout (addr_str, message) SELECT CONCAT(region1_name, ' - ', CONCAT_WS
		('', region2_name, ' ', city_name, ' ', city_area_name, ' ' , quarter_name, ' '
		)), 'Неправильная последовательность данных'
	FROM addr_loaded WHERE region1_name NOT LIKE '%обл.';
	
--Удаляем переброшенные записи в исходной таблице
DELETE FROM addr_loaded WHERE region1_name NOT LIKE '%обл.';

--Export CSV из таблицы addr_fallout
SELECT addr_str, message 
FROM addr_fallout 
INTO OUTFILE 'c:/addr_fallout.csv' 
FIELDS ENCLOSED BY '' 
	TERMINATED  BY ',' 
	ESCAPED BY '' 
	LINES TERMINATED BY '\r\n';