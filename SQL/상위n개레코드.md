## 상위n개레코드

```sql
SELECT name FROM ANIMAL_INS WHERE DATETIME = (SELECT MIN(DATETIME) FROM ANIMAL_INS);
/*가장 먼저 들어온 동물의 이름을 조회*/
```
## 다른풀이
```sql
SELECT NAME FROM ANIMAL_INS
ORDER BY DATETIME
LIMIT 1;
/*limit 사용하여 */
