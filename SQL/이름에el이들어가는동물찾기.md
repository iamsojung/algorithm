## 이름에 el이 들어가는 동물 찾기

```sql

SELECT ANIMAL_ID,NAME FROM ANIMAL_INS
WHERE NAME LIKE '%el%' and ANIMAL_TYPE='DOG'
ORDER BY NAME;
/*이름에 "EL"이 들어가는 개의 아이디와 이름을 조회*/
```
