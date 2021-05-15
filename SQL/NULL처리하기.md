## NULL처리하기

```sql
SELECT animal_type, if(name is null,"No name",name), sex_upon_intake
from animal_ins
order by animal_id;
/*아이디순으로 조회, 이름이 없는 동물의 이름은 "No name"으로 표시*/
```
