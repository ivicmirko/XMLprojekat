--categories of facility
INSERT INTO `megatravel`.`category` (`id`, `name`) VALUES ('1', 'nekategorisan');
INSERT INTO `megatravel`.`category` (`id`, `name`) VALUES ('2', '1 zvezdica');
INSERT INTO `megatravel`.`category` (`id`, `name`) VALUES ('3', '2 zvezdica');
INSERT INTO `megatravel`.`category` (`id`, `name`) VALUES ('4', '3 zvezdica');
INSERT INTO `megatravel`.`category` (`id`, `name`) VALUES ('5', '4 zvezdica');
INSERT INTO `megatravel`.`category` (`id`, `name`) VALUES ('6', '5 zvezdica');

--destination
INSERT INTO `megatravel`.`destination` (`id`, `latitude`, `longitude`, `name`) VALUES ('1', '48.137154', '11.576124', 'minhen');
INSERT INTO `megatravel`.`destination` (`id`, `latitude`, `longitude`, `name`) VALUES ('2', '44.786568', '20.448922', 'beograd');

--Facility AS 
INSERT INTO `megatravel`.`facilityas` (`id`, `name`) VALUES ('1', 'parking');
INSERT INTO `megatravel`.`facilityas` (`id`, `name`) VALUES ('2', 'wi-fi');
INSERT INTO `megatravel`.`facilityas` (`id`, `name`) VALUES ('3', 'dorucak');
INSERT INTO `megatravel`.`facilityas` (`id`, `name`) VALUES ('4', 'polu-pansion');
INSERT INTO `megatravel`.`facilityas` (`id`, `name`) VALUES ('5', 'pansion');
INSERT INTO `megatravel`.`facilityas` (`id`, `name`) VALUES ('6', 'all-inclusive');
INSERT INTO `megatravel`.`facilityas` (`id`, `name`) VALUES ('7', 'pet-friendly');

--facility types
INSERT INTO `megatravel`.`facility_type` (`id`, `name`) VALUES ('1', 'hotel');
INSERT INTO `megatravel`.`facility_type` (`id`, `name`) VALUES ('2', 'bed&breakfast');
INSERT INTO `megatravel`.`facility_type` (`id`, `name`) VALUES ('3', 'apartman');

--unit AS
INSERT INTO `megatravel`.`unitas` (`id`, `name`) VALUES ('1', 'tv');
INSERT INTO `megatravel`.`unitas` (`id`, `name`) VALUES ('2', 'mini kuhina/kuhinja');
INSERT INTO `megatravel`.`unitas` (`id`, `name`) VALUES ('3', 'privatno kupatilo');

--lokacije
INSERT INTO `megatravel`.`location` (`id`, `address`, `latitude`, `description`, `longitude`) VALUES ('1', 'Bulevar Nikole Tesle', '44.830008', 'Na Dunava.', '20.419823');
INSERT INTO `megatravel`.`location` (`id`, `address`, `latitude`, `description`, `longitude`) VALUES ('2', 'Prizrenska', '44.813169', 'Centar grada.', '20.460467');
INSERT INTO `megatravel`.`location` (`id`, `address`, `latitude`, `description`, `longitude`) VALUES ('3', 'Paul Heyse Strasse', '48.138129', 'Centar grada.', '11.555825');
INSERT INTO `megatravel`.`location` (`id`, `address`, `latitude`, `description`, `longitude`) VALUES ('4', 'Neuberger Strasse', '48.210418', 'Okolina Minhena.', '11.586669');


----facilities
--INSERT INTO `megatravel`.`accommodation_facility` (`id`, `description`, `image`, `name`, `rating`, `voters`, `category`, `destination`, `facility_type_id`, `location_id`, `agent_id`) VALUES ('1', 'Lep hotel veoma', '123', 'Hotel Moskva', '15', '3', '6', '2', '1', '2', '2');
--INSERT INTO `megatravel`.`accommodation_facility` (`id`, `description`, `image`, `name`, `rating`, `voters`, `category`, `destination`, `facility_type_id`, `location_id`, `agent_id`) VALUES ('2', 'Hotel s lepim pogledom.', '123', 'Hotel Jugolavija', '13', '3', '5', '2', '2', '1', '2');
--INSERT INTO `megatravel`.`accommodation_facility` (`id`, `description`, `image`, `name`, `rating`, `voters`, `category`, `destination`, `facility_type_id`, `location_id`, `agent_id`) VALUES ('3', 'Blizu centra Minhena.', '123', 'ArtStudio', '25', '6', '5', '1', '3', '3', '2');
--INSERT INTO `megatravel`.`accommodation_facility` (`id`, `description`, `image`, `name`, `rating`, `voters`, `category`, `destination`, `facility_type_id`, `location_id`, `agent_id`) VALUES ('4', 'Periferija minhena.', '123', 'Motel Hans', '33', '9', '1', '1', '2', '4', '2');
--
----facility & AS
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('1', '1');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('1', '2');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('1', '4');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('1', '5');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('1', '7');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('2', '1');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('2', '2');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('2', '4');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('2', '3');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('3', '1');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('3', '2');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('3', '3');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('3', '7');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('4', '1');
--INSERT INTO `megatravel`.`acc_facilityas` (`acc_facility_id`, `asf_id`) VALUES ('4', '3');

--pricePerMonth
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('1', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('2', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('3', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('4', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('5', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('6', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('7', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('8', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('9', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('10', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('11', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');
INSERT INTO `megatravel`.`price_per_month` (`id`, `april`, `august`, `december`, `february`, `january`, `july`, `june`, `march`, `may`, `november`, `october`, `september`) VALUES ('12', '10', '12', '15', '12', '13', '12', '10', '10', '12', '13', '11', '12');

----accommodationUnit
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('1', b'1', '2', '3', '1', '1');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('2', b'1', '2', '3', '1', '2');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('3', b'0', '3', '0', '1', '3');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('4', b'1', '3', '2', '2', '4');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('5', b'1', '3', '2', '2', '5');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('6', b'0', '2', '0', '2', '6');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('7', b'0', '2', '0', '3', '7');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('8', b'0', '2', '0', '3', '8');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('9', b'0', '2', '0', '3', '9');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('10', b'1', '4', '2', '4', '10');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('11', b'1', '5', '2', '4', '11');
--INSERT INTO `megatravel`.`accommodation_unit` (`id`, `can_be_cancelled`, `capacity`, `days_before`, `accommodation_facility`, `price_per_month_id`) VALUES ('12', b'1', '2', '0', '4', '12');
--
----unit_as
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('1', '1');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('1', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('2', '1');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('2', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('3', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('4', '2');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('4', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('5', '1');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('5', '2');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('5', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('6', '1');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('6', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('7', '1');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('7', '2');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('7', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('8', '1');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('8', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('9', '1');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('9', '2');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('9', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('10', '2');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('11', '3');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('12', '1');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('12', '2');
--INSERT INTO `megatravel`.`acc_unitas` (`acc_unit_id`, `as_id`) VALUES ('12', '3');
--
------res
--INSERT INTO `megatravel`.`reservation` (`id`, `check_in_date`, `check_out_date`, `guest_user_name`, `is_realised`, `total_price`, `accommodation_unit`) VALUES ('1', '2019-9-16', '2019-9-18', 'mate', b'0', '24', '7');

