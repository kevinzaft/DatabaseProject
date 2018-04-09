--note that unless the question specified, the values such as Edgar or main or Irish could be interchanged

select * from resturant join location on resturantID=resturantID where name='Edgar';

select * from menu_item where restaurant_id in (select restaurant_id from resturant where name='Edgar') order by category;

select manager_name, first_open_date from location where restaurant_id in (select restaurant_id from menu_item where category='Thai');

select menu_item.name, manager_name, hour_open, url from menu_item join restaurant on menu_item.restaurant_id=restaurant.restaurant_id join location on menu_item.restaurant_id=location.restaurant_id where menu_item.price in (select max(price) as price from menu_item where restaurant_id in (select restaurant_id from restaurant where name='Edgar'));

select avg(price) from menu_item where category='main' and restaurant_id in (select restaurant_id from restaurant where type='Irish');




select count(user_id) from rating where restaurant_id in (select restaurant_id from rating where user_id in (select rater_id as user_id from rater));

select r.name, l.phone_number, r.type
from restaurant r, location l
where r.restaurant_id = l.restaurant_id and
r.restaurant_id not in(
select restaurant_id
from rating
where
rating.date > '2015-01-01' and rating.date < '2015-02-01')

select restaurant.name, first_open_date from restaurant join location on restaurant.restaurant_id=location.restaurant_id where restaurant.restaurant_id in (select restaurant_id from rating where staff< (select min(rating) as rating from rating_item where user_id in (select rater_id as user_id from rater where name='Rater X')));

select restaurant.name as restaurant_name, rater.name as rater_name from rating join rater on user_id=rater_id join restaurant on rating.restaurant_id=restaurant.restaurant_id where food in (select max(food) as food from rating where restaurant_id in (select restaurant_id from restaurant where type='Burger'));

-- (select rating, case when ((select rating from rating_item where item_id in (select item_id from menu_item where restaurant_id in (select restaurant_id from restaurant where type='Type Y')))<(select avg(rating) as rating from rating_item where item_id in (select item_id from menu_item where restaurant_id in (select restaurant_id from restaurant where not type='Type Y')))) then true else false end from rating_item);
select r.name
from restaurant r, rating ra
where r.restaurant_id = ra.restaurant_id and
(ra.price + ra.food + ra.mood + ra.staff)/4 >
(((select AVG(ra.price) from rating ra)+(select AVG(ra.food) from rating ra)+(select AVG(ra.mood) from rating ra)+(select AVG(ra.staff) from rating ra))/4)



select name, join_date, reputation from rater where rater_id in (select user_id as rater_id from rating where food in (select max(food) as food from rating) and mood in (select max(mood) as mood from rating));

-- select rater.name, reputation, date from rater join rating on rater_id=rating.user_id join restaurant on rating.restaurant_id=restaurant.restaurant_id  where rater_id in (select user_id as rater_id from rating where food in (select max(food) as food from rating) and mood in (select max(mood) as mood from rating));
select rr.name, rr.reputation, r.name, ra.date, ra.food, ra.mood
FROM rater rr, rating ra, restaurant r
WHERE rr.rater_id = ra.user_id and ra.restaurant_id = r.restaurant_id
AND (rr.rater_id IN (SELECT ra.user_id from rating ra where ra.mood = (select max(ra.mood) from rating ra))
    OR rr.rater_id IN (SELECT ra.user_id from rating ra where ra.food = (select max(ra.food) from rating ra)))

-- select rater.name, rater.reputation, comments, menu_item.name, menu_item.price from rating join rater on rating.user_id=rater.rater_id join menu_item on rating.restaurant_id=menu_item.restaurant_id where user_id in (select distinct r1.user_id from (select user_id, count(user_id) as id_occurance from rating where restaurant_id in (select restaurant_id from restaurant where name='Restaurant Z') group by user_id order by user_id) as r1);
select rr.name, rr.reputation, ra.comments, mi.name, mi.price
                from Rating ra join Rater rr on ra.user_id = rr.rater_id join menu_item mi on ra.restaurant_id = mi.restaurant_id
                where ra.user_id in (select distinct r1.user_id from (select ra.user_id, count(ra.user_id) as id_occurance from Rating ra where ra.restaurant_id in (select r.restaurant_id from Restaurant r where name='Le BBQ Shop')
                group by ra.user_id order by ra.user_id) as r1)

-- select name, email from rater where rater_id in (select user_id as rater_id from rating_item where rating< (select least(john_stuff.price, john_stuff.food, john_stuff.mood, john_stuff.staff) from (select price, food, mood, staff from rating where user_id in (select rater_id as user_id from rater where name='John')) as john_stuff) );
select name, email
from rater
where rater_id in (
	  select user_id
	  from rating where (price + food +mood +staff)<
							(select min(price + food + mood + staff)
							from rating where user_id in (select rater_id from rater where name='John')))
//
select rr.name, rr.type, email, r.name, ra.price, ra.food, ra.mood, ra.staff
from rater rr, rating ra, restaurant r
WHERE rr.rater_id = ra.user_id and ra.restaurant_id = r.restaurant_id
GROUP by rr.name, rr.type, email, r.name, ra.price, ra.food, ra.mood, ra.staff
HAVING count(r.name) > 5





