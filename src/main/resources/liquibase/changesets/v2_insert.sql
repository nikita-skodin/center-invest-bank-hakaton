insert into address(address, coordinates)
VALUES ('Агрогородок Лесной,Александрова улица, дом 7', '54.013194, 27.68137');

insert into events(title, description, date_of_publishment,
                   date_of_event, contact_number, working_hours,
                   address_id, total_stars, review_counter,
                   start_time, end_time)
VALUES ('event', 'event desc', current_timestamp,
        current_timestamp, 9696, '12 - 12', 1, 3, 3,
        current_timestamp, current_timestamp)