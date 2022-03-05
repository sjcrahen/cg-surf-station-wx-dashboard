insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('barnegat-light', 'Barnegat Light', '44091', 
		'https://www.ndbc.noaa.gov/station_page.php?station=44091', null, 
		null, '08005', 
		'8533615', 'ACT4001','44091 - BARNEGAT',null,'BARNEGAT INLET',
		'Barnegat Light, NJ', 'https://embed.windy.com/embed2.html?lat=39.752&lon=-74.090&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'BARNEGAT INLET');

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('bodega-bay', 'Bodega Bay', '46214', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46214', null, 
		null, '94922', 
		'9415625', null,'46214 - POINT REYES',	null,	'BODEGA HARBOR ENTRANCE',
		'Bodega, CA', 'https://embed.windy.com/embed2.html?lat=38.302&lon=-123.196&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null);

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('cape-disappointment', 'Cape Disappointment', '46243', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46243', '46029', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46029', '98624', 
		'9440574', 'PCT1121','46243 - CLATSOP SPIT',	'46029 - COLUMBIA RIVER BAR',
		'COLUMBIA RIVER ENTRANCE',	'Ilwaco, WA', 'https://embed.windy.com/embed2.html?lat=46.265&lon=-124.057&detaillat=46.265&etaillon=-124.057&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'CLATSOP SPIT');
		
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('chetco-river', 'Chetco River', '46027', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46027', '46027', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46027', '97415', 
		'9430104', null,'46027 - ST GEORGES',	'46027 - ST GEORGES',	
		'CHETCO COVE',	'Harbor, OR', 'https://embed.windy.com/embed2.html?lat=42.179&lon=-124.542&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null);
		
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('coos-bay', 'Coos Bay', '46229', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46229', 'CHAO3', 
		'https://www.ndbc.noaa.gov/station_page.php?station=CHAO3', '97420', 
		'9432780', 'PCT1061','46229 - UMPQUA OFFSHORE',	'CHAO3 - CHARLESTON',
		'CHARLESTON', 'Charleston, OR', 'https://embed.windy.com/embed2.html?lat=43.274&lon=-124.564&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'COOS BAY ENTRANCE');
	
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('coquille-river', 'Coquille River', '46015', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46015', 'PORO3', 
		'https://www.ndbc.noaa.gov/station_page.php?station=PORO3', '97411', 
		'9432373', 'PCT1056','46015 - PORT ORFORD',	'PORO3 - PORT ORFORD',
		'COQUILLE RIVER',	'Bandon, OR', 'https://embed.windy.com/embed2.html?lat=43.274&lon=-124.564&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'COQUILLE RIVER ENTRANCE');
		
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('depoe-bay', 'Depoe Bay', '46050', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46050', '46050', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46050', '97341', 
		'9435827', null,'46050 - STONEWALL BANK',	'46050 - STONEWALL BANK', 
		'DEPOE BAY','Depoe Bay, OR', 'https://embed.windy.com/embed2.html?lat=44.645&lon=-124.176&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null);

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('golden-gate', 'Golden Gate', '46026', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46026', '46026', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46026', '94965', 
		'9414906', 'PCT0181','46026 - SAN FRANCISCO',	'46026 - SAN FRANCISCO',
		'POINT BONITA',	'Sausalito, CA', 'https://embed.windy.com/embed2.html?lat=37.795&lon=-122.725&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'POINT BONITA LT');

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('grays-harbor', 'Grays Harbor', '46211', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46211', 'WPTW1', 
		'https://www.ndbc.noaa.gov/station_page.php?station=WPTW1', '98595', 
		'9441102', 'PCT1291','46211 - GRAYS HARBOR', 'WPTW1 - WESTPORT',
		'POINT CHEHALIS', 'Westport, WA', 'https://embed.windy.com/embed2.html?lat=46.898&lon=-124.161&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'GRAYS HARBOR ENTRANCE');

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('hatteras-inlet', 'Hatteras Inlet', '41120', 
		'https://www.ndbc.noaa.gov/station_page.php?station=41120', '41025', 
		'https://www.ndbc.noaa.gov/station_page.php?station=41025', '27943', 
		'TEC2791', 'ACT6286','41120 - CAPE HATTERAS EAST','41025 - DIAMOND SHOALS',
		'HATTERAS INLET','Hatteras, NC', 'https://embed.windy.com/embed2.html?lat=35.143&lon=-75.938&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'HATTERAS INLET');

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('humboldt-bay', 'Humboldt Bay', '46244', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46244', '46022', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46022', '95564', 
		'9418767', null,'46244 - HUMBOLDT BAY',	'46022 - EEL RIVER',
		'HUMBOLDT BAY NORTH SPIT',	'Samoa, CA', 'https://embed.windy.com/embed2.html?lat=40.781&lon=-124.364&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null);
																
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('merrimack-river', 'Merrimack River', '44098', 
		'https://www.ndbc.noaa.gov/station_page.php?station=44098', 'IOSN3', 
		'https://www.ndbc.noaa.gov/station_page.php?station=IOSN3', '01950', 
		'8440452', 'ACT0816','44098 - JEFFREYS LEDGE', 'IOSN3 - ISLE OF SHOALS',
		'MERRIMACK RIVER ENTRANCE','Newburyport, MA', 'https://embed.windy.com/embed2.html?lat=42.841&lon=-70.863&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'MERRIMACK RIVER ENTRANCE');

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('morro-bay', 'Morro Bay', '46011', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46011', '46011', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46011', '93442', 
		'9412110', null,'46011 - SANTA MARIA',	'46011 - SANTA MARIA',
		'PORT SAN LUIS',	'Morro Bay, CA', 'https://embed.windy.com/embed2.html?lat=35.341&lon=-120.981&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null);

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('noyo-river', 'Noyo River', '46014', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46014', '46014', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46014', '95437', 
		'9417426', null,'46014 - PT ARENA',	'46014 - PT ARENA',
		'NOYO HARBOR',	'Fort Bragg, CA', 'https://embed.windy.com/embed2.html?lat=39.415&lon=-123.994&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null);

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('ocracoke-inlet', 'Ocracoke Inlet', '41120', 
		'https://www.ndbc.noaa.gov/station_page.php?station=41120', '41025', 
		'https://www.ndbc.noaa.gov/station_page.php?station=41025', '27960', 
		'TEC2793', 'ACT6296','41120 - CAPE HATTERAS EAST','41025 - DIAMOND SHOALS',
		'OCRACOKE INLET','Ocracoke, NC', 'https://embed.windy.com/embed2.html?lat=35.143&lon=-75.938&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'OCRACOKE INLET');
				
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('oregon-inlet', 'Oregon Inlet', '44095', 
		'https://www.ndbc.noaa.gov/station_page.php?station=44095', 'ORIN7', 
		'https://www.ndbc.noaa.gov/station_page.php?station=ORIN7', '27959', 
		'8652678', 'ACT6271','44095 - OREGON INLET','ORIN7 - OREGON INLET MARINA',
		'OREGON INLET','Nags Head, NC', 'https://embed.windy.com/embed2.html?lat=35.767&lon=-75.542&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'OREGON INLET');

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('quillayute-river', 'Quillayute River', '46041', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46041', 'LAPW1', 
		'https://www.ndbc.noaa.gov/station_page.php?station=LAPW1', '98350', 
		'9442388', 'PCT1321','46041 - CAPE ELIZABETH','LAPW1 - LA PUSH',
		'QUILLAYUTE RIVER',	'La Push, WA', 'https://embed.windy.com/embed2.html?lat=47.893&lon=-124.629&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'QUILLAYUTE RIVER ENTRANCE');

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('rogue-river', 'Rogue River', '46015', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46015', 'PORO3', 
		'https://www.ndbc.noaa.gov/station_page.php?station=PORO3', '97444', 
		'9431011', null,'46015 - PORT ORFORD',	'PORO3 - PORT ORFORD',	
		'ROGUE RIVER',	'Gold Beach, OR', 'https://embed.windy.com/embed2.html?lat=42.179&lon=-124.542&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null);
		
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('siuslaw-river', 'Siuslaw River', '46229', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46229', null, 
		null, '97439', 
		'9434132', null,'46229 - UMPQUA OFFSHORE',	null,	'SIUSLAW RIVER ENTRANCE',
		'Florence, OR', 'https://embed.windy.com/embed2.html?lat=43.808&lon=-124.303&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null);
		
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('tillamook-bay', 'Tillamook Bay', '46243', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46243', null, 
		null, '97118', 
		'9437585', 'PCT1096','46243 - CLATSOP SPIT',	null,	'NORTH JETTY',
		'Garibaldi, OR', 'https://embed.windy.com/embed2.html?lat=45.542&lon=-124.016&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'TILLAMOOK BAY ENTRANCE');

insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('umpqua-river', 'Umpqua River', '46229', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46229', null, 
		null, '97467', 
		'9433445', 'PCT1066','46229 - UMPQUA OFFSHORE',	null,	'UMPQUA RIVER ENTRANCE',
		'Winchester Bay, OR', 'https://embed.windy.com/embed2.html?lat=43.808&lon=-124.303&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'UMPQUA RIVER ENTRANCE');
	
insert into stations 
	(station_id, station_name, waves_source_id, waves_source_url, 
		wind_source_id, wind_source_url, weather_source_id, tide_source_id, 
		current_source_id, waves_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name) 
values
	('yaquina-bay', 'Yaquina Bay', '46050', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46050', '46050', 
		'https://www.ndbc.noaa.gov/station_page.php?station=46050', '97365', 
		'9435380', 'PCT1076','46050 - STONEWALL BANK',	'46050 - STONEWALL BANK',
		'SOUTHBEACH',	'Newport, OR', 'https://embed.windy.com/embed2.html?lat=44.645&lon=-124.176&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'YAQUINA BAY ENTRANCE');
		