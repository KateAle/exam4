Выбор того или иного варианта не будет влиять на оценку.

### Вариант №1 (проще)

Приложение хранит следующую информацию:

1. Альпинисты (полное имя; адрес проживания)
2. Горы (название; страна; высота)
3. Группа для восхождения на гору (альпинисты, записавшиеся в группу; идёт набор в группу или нет; гора; дата и время
   начала и окончания похода):

Задания:
1. Необходимо расставить аннотации JPA, чтобы были созданы таблицы в соответствии с описанием.
   2. Написать следующие SQL запросы:
   1) получить название гор, на которые уже состоялись восхождения
   

     SELECT tb_mountain.name AS mountain_name
     FROM tb_mountain
     JOIN tb_group
     WHERE dateEnd < '2023-06-23 00:00:00';
   

   2) получить название гор, на которые не было ни одного восхождения 
    
      

    SELECT tb_mountain.name AS mountain_name
    FROM tb_mountain
    JOIN tb_group
    WHERE dateStart > '2023-06-23 00:00:00';

   3) получить имена альпинистов, которые ходили в поход на гору с определенным названием 
    

    SELECT tb_climber.name AS climber_name
    FROM tb_climber
    JOIN tb_group
    JOIN tb_mountain
    ON tb_group.id = tb_mountain_id
    WHERE tb_mountain.name = 'mount';   


   4) получить названия и высоту гор, восхождение на которые планируется в определенный интервал времени
      
   
    SELECT tb_mountain.name, tb_mountain.height AS GROUP
    FROM tb_group
    JOIN tb_mountain
    WHERE dateStart BETWEEN '2023-05-01 11:00:00' AND '2023-06-23 00:00:00';



   5) получить имена альпинистов, которые не записались в новые (время начала похода в будущем) группы 


    SELECT tb_climber.name AS climber_name
    FROM tb_climber
    JOIN tb_group
    WHERE dateEnd < '2023-06-23 00:00:00';

   