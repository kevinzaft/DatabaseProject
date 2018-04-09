
select * from resturant join location on resturantID=resturantID where name='Edgar';

select * from menu_item where restaurant_id in (select restaurant_id from resturant where name='Edgar') order by category;

select manager_name, first_open_date from location where restaurant_id in (select restaurant_id from menu_item where category='Thai');
 
select menu_item.name, manager_name, hour_open, url from menu_item join restaurant on menu_item.restaurant_id=restaurant.restaurant_id join location on menu_item.restaurant_id=location.restaurant_id where menu_item.price in (select max(price) as price from menu_item where restaurant_id in (select restaurant_id from restaurant where name='Edgar'));

select avg(price) from menu_item where category='main' and restaurant_id in (select restaurant_id from restaurant where type='Irish');




select count(user_id) from rating where restaurant_id in (select restaurant_id from rating where user_id in (select rater_id as user_id from rater));

select restaurant.name, phone_number, restaurant.type from rating join restaurant on rating.restaurant_id=restaurant.restaurant_id join location on rating.restaurant_id=location.restaurant_id where rating.restaurant_id not in (select restaurant_id from rating where extract('month' from timestamp '2015-01-01')=1 and extract('year' from timestamp '2015-01-01')=2015); 

select restaurant.name, first_open_date from restaurant join location on restaurant.restaurant_id=location.restaurant_id where restaurant.restaurant_id in (select restaurant_id from rating where staff< (select min(rating) as rating from rating_item where user_id in (select rater_id as user_id from rater where name='Rater X')));

select restaurant.name as restaurant_name, rater.name as rater_name from rating join rater on user_id=rater_id join restaurant on rating.restaurant_id=restaurant.restaurant_id where food in (select max(food) as food from rating where restaurant_id in (select restaurant_id from restaurant where type='Burger'));

(select rating, case when ((select rating from rating_item where item_id in (select item_id from menu_item where restaurant_id in (select restaurant_id from restaurant where type='Type Y')))<(select avg(rating) as rating from rating_item where item_id in (select item_id from menu_item where restaurant_id in (select restaurant_id from restaurant where not type='Type Y')))) then true else false end from rating_item);




select name, join_date, reputation from rater where rater_id in (select user_id as rater_id from rating where food in (select max(food) as food from rating) and mood in (select max(mood) as mood from rating));

select rater.name, reputation, date from rater join rating on rater_id=rating.user_id join restaurant on rating.restaurant_id=restaurant.restaurant_id  where rater_id in (select user_id as rater_id from rating where food in (select max(food) as food from rating) and mood in (select max(mood) as mood from rating));

select rater.name, rater.reputation, comments, menu_item.name, menu_item.price from rating join rater on rating.user_id=rater.rater_id join menu_item on rating.restaurant_id=menu_item.restaurant_id where user_id in (select distinct r1.user_id from (select user_id, count(user_id) as id_occurance from rating where restaurant_id in (select restaurant_id from restaurant where name='Restaurant Z') group by user_id order by user_id) as r1);

select name, email from rater where rater_id in (select user_id as rater_id from rating_item where rating< (select least(john_stuff.price, john_stuff.food, john_stuff.mood, john_stuff.staff) from (select price, food, mood, staff from rating where user_id in (select rater_id as user_id from rater where name='John')) as john_stuff) );

//





