insert into users
	(username, password, enabled, authority)
values ('scrahen','$2a$10$cMtLsEOa.sLJVy1.NYvD.uLqstOGSTA9XGNV81MJoLJyREoU/rJaS', true, 'ROLE_ADMIN');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('barnegat-light', 'Barnegat Light', '44091', null, '08005', '8533615', 'ACT4001',
		'44091 - BARNEGAT',null,'BARNEGAT INLET', 'Barnegat Light, NJ', 
		'39.752','-74.090',
		'America/New_York', 'BARNEGAT INLET', 'FZUS51.KPHI');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('bodega-bay', 'Bodega Bay', '46214', null, '94922', '9415625', null,
		'46214 - POINT REYES', null, 'BODEGA HARBOR ENTRANCE', 'Bodega, CA', 
		'38.302','-123.196',
		'America/Los_Angeles', null, 'FZUS56.KMTR');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('cape-disappointment', 'Cape Disappointment', '46243', '46029', '98624', '9440574', 'PCT1121', 
		'46243 - CLATSOP SPIT', '46029 - COLUMBIA RIVER BAR', 'COLUMBIA RIVER ENTRANCE', 'Ilwaco, WA', 
		'46.265','-124.057',
		'America/Los_Angeles', 'CLATSOP SPIT', 'FZUS56.KPQR');
		
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, wave_source_id_2, wave_source_name_2, forecast_source) 
values
	('chetco-river', 'Chetco River', '46027', '46027', '97415', '9430104', null,
		'46027 - ST GEORGES', '46027 - ST GEORGES', 'CHETCO COVE', 'Harbor, OR', 
		'42.179','-124.542',
		'America/Los_Angeles', null, '46015', '46015 - PORT ORFORD', 'FZUS56.KMFR');
		
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, wave_source_id_2, wave_source_name_2, forecast_source)  
values
	('coos-bay', 'Coos Bay', '46229', 'CHAO3', '97420', '9432780', 'PCT1061',
		'46229 - UMPQUA OFFSHORE', 'CHAO3 - CHARLESTON', 'CHARLESTON', 'Charleston, OR', 
		'43.274','-124.564',
		'America/Los_Angeles', 'COOS BAY ENTRANCE', '46015', '46015 - PORT ORFORD', 'FZUS56.KMFR');
	
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('coquille-river', 'Coquille River', '46015', 'PORO3', '97411', '9432373', 'PCT1056',
		'46015 - PORT ORFORD',	'PORO3 - PORT ORFORD', 'COQUILLE RIVER', 'Bandon, OR', 
		'43.274','-124.564',
		'America/Los_Angeles', 'COQUILLE RIVER ENTRANCE', 'FZUS56.KMFR');
		
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('depoe-bay', 'Depoe Bay', '46050', '46050', '97341', '9435827', null,
		'46050 - STONEWALL BANK',	'46050 - STONEWALL BANK', 'DEPOE BAY','Depoe Bay, OR', 
		'44.645','-124.176',
		'America/Los_Angeles', null, 'FZUS56.KPQR');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('golden-gate', 'Golden Gate', '46026', '46026', '94965', '9414906', 
		'PCT0181','46026 - SAN FRANCISCO',	'46026 - SAN FRANCISCO', 'POINT BONITA', 'Sausalito, CA', 
		'37.795','-122.725',
		'America/Los_Angeles', 'POINT BONITA LT', 'FZUS56.KMTR');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('grays-harbor', 'Grays Harbor', '46211', 'WPTW1', '98595', '9441102', 'PCT1291',
		'46211 - GRAYS HARBOR', 'WPTW1 - WESTPORT', 'POINT CHEHALIS', 'Westport, WA', 
		'46.898','-124.161',
		'America/Los_Angeles', 'GRAYS HARBOR ENTRANCE', 'FZUS56.KSEW');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('hatteras-inlet', 'Hatteras Inlet', '41120', '41025', '27943', 'TEC2791', 'ACT6286',
		'41120 - CAPE HATTERAS EAST','41025 - DIAMOND SHOALS', 'HATTERAS INLET','Hatteras, NC', 
		'35.143','-75.938',
		'America/New_York', 'HATTERAS INLET', 'FZUS52.KMHX');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('humboldt-bay', 'Humboldt Bay', '46244', '46022', '95564', '9418767', null,
		'46244 - HUMBOLDT BAY',	'46022 - EEL RIVER', 'HUMBOLDT BAY NORTH SPIT',	'Samoa, CA', 
		'40.781','-124.364',
		'America/Los_Angeles', null, 'FZUS56.KEKA');
																
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('merrimack-river', 'Merrimack River', '44098', 'IOSN3', '01950', '8440452', 'ACT0816',
		'44098 - JEFFREYS LEDGE', 'IOSN3 - ISLE OF SHOALS', 'MERRIMACK RIVER ENTRANCE','Newburyport, MA', 
		'42.841','-70.863',
		'America/New_York', 'MERRIMACK RIVER ENTRANCE', 'FZUS51.KBOX');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, wave_source_id_2, wave_source_name_2, forecast_source) 
values
	('morro-bay', 'Morro Bay', '46215', '46011', '93442', '9412110', null,
		'46215 - DIABLO CANYON',	'46011 - SANTA MARIA', 'PORT SAN LUIS',	'Morro Bay, CA', 
		'35.341','-120.981',
		'America/Los_Angeles', null, '46011', '46011 - SANTA MARIA', 'FZUS56.KLOX');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('noyo-river', 'Noyo River', '46014', '46014', '95437', '9417426', null,
		'46014 - PT ARENA',	'46014 - PT ARENA', 'NOYO HARBOR', 'Fort Bragg, CA', 
		'39.415','-123.994',
		'America/Los_Angeles', null, 'FZUS56.KEKA');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('ocracoke-inlet', 'Ocracoke Inlet', '41120', '41025', '27960', 'TEC2793', 'ACT6296',
		'41120 - CAPE HATTERAS EAST','41025 - DIAMOND SHOALS', 'OCRACOKE INLET','Ocracoke, NC', 
		'35.143','-75.938',
		'America/New_York', 'OCRACOKE INLET', 'FZUS52.KMHX');
				
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('oregon-inlet', 'Oregon Inlet', '44095', 'ORIN7', '27959', '8652678', 'ACT6271',
		'44095 - OREGON INLET','ORIN7 - OREGON INLET MARINA', 'OREGON INLET','Nags Head, NC', 
		'35.767','-75.542',
		'America/New_York', 'OREGON INLET', 'FZUS52.KMHX');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('quillayute-river', 'Quillayute River', '46206', 'LAPW1', '98350', '9442388', 'PCT1321','46206 - LA PEROUSE BANK',
		'LAPW1 - LA PUSH', 'QUILLAYUTE RIVER',	'La Push, WA', 
		'47.893','-124.629',
		'America/Los_Angeles', 'QUILLAYUTE RIVER ENTRANCE', 'FZUS56.KSEW');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('rogue-river', 'Rogue River', '46015', 'PORO3', '97444', '9431011', null,
		'46015 - PORT ORFORD',	'PORO3 - PORT ORFORD',	'ROGUE RIVER',	'Gold Beach, OR', 
		'42.179','-124.542',
		'America/Los_Angeles', null, 'FZUS56.KMFR');
		
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, wave_source_id_2, wave_source_name_2, forecast_source) 
values
	('siuslaw-river', 'Siuslaw River', '46229', '46098', '97439', '9434132', null,
		'46229 - UMPQUA OFFSHORE', '46098 - WALDPORT OFFSHORE', 'SIUSLAW RIVER ENTRANCE', 'Florence, OR', 
		'43.808','-124.303',
		'America/Los_Angeles', null, '46050', '46050 - STONEWALL BANK', 'FZUS56.KMFR');
		
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, wave_source_id_2, wave_source_name_2, forecast_source) 
values
	('tillamook-bay', 'Tillamook Bay', '46248', null, '97118', '9437585', 'PCT1096',
		'46248 - ASTORIA CANYON', null,	'NORTH JETTY', 'Garibaldi, OR', 
		'45.542','-124.016',
		'America/Los_Angeles', 'TILLAMOOK BAY ENTRANCE', '46050', '46050 - STONEWALL BANK', 'FZUS56.KPQR');

insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('umpqua-river', 'Umpqua River', '46229', '46098', '97467', '9433445', 'PCT1066',
		'46229 - UMPQUA OFFSHORE',	'46098 - WALDPORT OFFSHORE', 'UMPQUA RIVER ENTRANCE', 'Winchester Bay, OR', 
		'43.808','-124.303',
		'America/Los_Angeles', 'UMPQUA RIVER ENTRANCE', 'FZUS56.KMFR');
	
insert into stations 
	(station_id, station_name, wave_source_id, wind_source_id, weather_source_id, tide_source_id, current_source_id, 
	wave_source_name, wind_source_name, tide_source_name, city, 
	lat, long, 
	time_zone, current_source_name, forecast_source) 
values
	('yaquina-bay', 'Yaquina Bay', '46050', '46050', '97365', '9435380', 'PCT1076',
		'46050 - STONEWALL BANK', '46050 - STONEWALL BANK', 'SOUTHBEACH', 'Newport, OR', 
		'44.645','-124.176',
		'America/Los_Angeles', 'YAQUINA BAY ENTRANCE', 'FZUS56.KPQR');
		