## DATETIME에서 DATE로 형 변환

```sql
SELECT ANIMAL_ID,NAME,date_format(datetime, '%Y-%m-%d') AS 날짜
FROM ANIMAL_INS;
/*동물의 아이디와 이름, 들어온 날짜1를 조회하는 SQL문을 작성*/
```
