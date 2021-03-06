insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('barnegat-light', 'Barnegat Light', '44091', null, '08005', 
		'8533615', 'ACT4001','44091 - BARNEGAT',null,'BARNEGAT INLET',
		'Barnegat Light, NJ', 'https://embed.windy.com/embed2.html?lat=39.752&lon=-74.090&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'BARNEGAT INLET', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS51.KPHI.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('bodega-bay', 'Bodega Bay', '46214', null, '94922', 
		'9415625', null,'46214 - POINT REYES',	null,	'BODEGA HARBOR ENTRANCE',
		'Bodega, CA', 'https://embed.windy.com/embed2.html?lat=38.302&lon=-123.196&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null, 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KMTR.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('cape-disappointment', 'Cape Disappointment', '46243', '46029', '98624', 
		'9440574', 'PCT1121','46243 - CLATSOP SPIT',	'46029 - COLUMBIA RIVER BAR',
		'COLUMBIA RIVER ENTRANCE',	'Ilwaco, WA', 'https://embed.windy.com/embed2.html?lat=46.265&lon=-124.057&detaillat=46.265&etaillon=-124.057&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'CLATSOP SPIT', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KPQR.html');
		
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, wave_source_id_2,
		wave_source_name_2, forecast_source) 
values
	('chetco-river', 'Chetco River', '46027', '46027', '97415', 
		'9430104', null,'46027 - ST GEORGES',	'46027 - ST GEORGES',	
		'CHETCO COVE',	'Harbor, OR', 'https://embed.windy.com/embed2.html?lat=42.179&lon=-124.542&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null, '46015', '46015 - PORT ORFORD', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KMFR.html');
		
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, wave_source_id_2,
		wave_source_name_2, forecast_source) 
values
	('coos-bay', 'Coos Bay', '46229', 'CHAO3', '97420', 
		'9432780', 'PCT1061','46229 - UMPQUA OFFSHORE',	'CHAO3 - CHARLESTON',
		'CHARLESTON', 'Charleston, OR', 'https://embed.windy.com/embed2.html?lat=43.274&lon=-124.564&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'COOS BAY ENTRANCE', '46015', '46015 - PORT ORFORD', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KMFR.html');
	
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('coquille-river', 'Coquille River', '46015', 'PORO3', '97411', 
		'9432373', 'PCT1056','46015 - PORT ORFORD',	'PORO3 - PORT ORFORD',
		'COQUILLE RIVER',	'Bandon, OR', 'https://embed.windy.com/embed2.html?lat=43.274&lon=-124.564&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'COQUILLE RIVER ENTRANCE', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KMFR.html');
		
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('depoe-bay', 'Depoe Bay', '46050', '46050', '97341', 
		'9435827', null,'46050 - STONEWALL BANK',	'46050 - STONEWALL BANK', 
		'DEPOE BAY','Depoe Bay, OR', 'https://embed.windy.com/embed2.html?lat=44.645&lon=-124.176&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null, 'https://www.ndbc.noaa.gov/station_page.php?station=46050');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('golden-gate', 'Golden Gate', '46026', '46026', '94965', 
		'9414906', 'PCT0181','46026 - SAN FRANCISCO',	'46026 - SAN FRANCISCO',
		'POINT BONITA',	'Sausalito, CA', 'https://embed.windy.com/embed2.html?lat=37.795&lon=-122.725&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'POINT BONITA LT', 'https://www.ndbc.noaa.gov/station_page.php?station=46026');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('grays-harbor', 'Grays Harbor', '46211', 'WPTW1', '98595', 
		'9441102', 'PCT1291','46211 - GRAYS HARBOR', 'WPTW1 - WESTPORT',
		'POINT CHEHALIS', 'Westport, WA', 'https://embed.windy.com/embed2.html?lat=46.898&lon=-124.161&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'GRAYS HARBOR ENTRANCE', 'https://www.ndbc.noaa.gov/station_page.php?station=46211');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('hatteras-inlet', 'Hatteras Inlet', '41120', '41025', '27943', 
		'TEC2791', 'ACT6286','41120 - CAPE HATTERAS EAST','41025 - DIAMOND SHOALS',
		'HATTERAS INLET','Hatteras, NC', 'https://embed.windy.com/embed2.html?lat=35.143&lon=-75.938&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'HATTERAS INLET', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS52.KMHX.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('humboldt-bay', 'Humboldt Bay', '46244', '46022', '95564', 
		'9418767', null,'46244 - HUMBOLDT BAY',	'46022 - EEL RIVER',
		'HUMBOLDT BAY NORTH SPIT',	'Samoa, CA', 'https://embed.windy.com/embed2.html?lat=40.781&lon=-124.364&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null, 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KEKA.html');
																
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('merrimack-river', 'Merrimack River', '44098', 'IOSN3', '01950', 
		'8440452', 'ACT0816','44098 - JEFFREYS LEDGE', 'IOSN3 - ISLE OF SHOALS',
		'MERRIMACK RIVER ENTRANCE','Newburyport, MA', 'https://embed.windy.com/embed2.html?lat=42.841&lon=-70.863&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'MERRIMACK RIVER ENTRANCE', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS51.KBOX.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, wave_source_id_2,
		wave_source_name_2, forecast_source) 
values
	('morro-bay', 'Morro Bay', '46215', '46011', '93442', 
		'9412110', null,'46215 - DIABLO CANYON',	'46011 - SANTA MARIA',
		'PORT SAN LUIS',	'Morro Bay, CA', 'https://embed.windy.com/embed2.html?lat=35.341&lon=-120.981&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null, '46011', '46011 - SANTA MARIA', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KLOX.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('noyo-river', 'Noyo River', '46014', '46014', '95437', 
		'9417426', null,'46014 - PT ARENA',	'46014 - PT ARENA',
		'NOYO HARBOR',	'Fort Bragg, CA', 'https://embed.windy.com/embed2.html?lat=39.415&lon=-123.994&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null, 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KEKA.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('ocracoke-inlet', 'Ocracoke Inlet', '41120', '41025', '27960', 
		'TEC2793', 'ACT6296','41120 - CAPE HATTERAS EAST','41025 - DIAMOND SHOALS',
		'OCRACOKE INLET','Ocracoke, NC', 'https://embed.windy.com/embed2.html?lat=35.143&lon=-75.938&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'OCRACOKE INLET', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS52.KMHX.html');
				
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('oregon-inlet', 'Oregon Inlet', '44095', 'ORIN7', '27959', 
		'8652678', 'ACT6271','44095 - OREGON INLET','ORIN7 - OREGON INLET MARINA',
		'OREGON INLET','Nags Head, NC', 'https://embed.windy.com/embed2.html?lat=35.767&lon=-75.542&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/New_York', 'OREGON INLET', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS52.KMHX.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('quillayute-river', 'Quillayute River', '46206', 'LAPW1', '98350', 
		'9442388', 'PCT1321','46206 - LA PEROUSE BANK','LAPW1 - LA PUSH',
		'QUILLAYUTE RIVER',	'La Push, WA', 'https://embed.windy.com/embed2.html?lat=47.893&lon=-124.629&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'QUILLAYUTE RIVER ENTRANCE', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KSEW.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('rogue-river', 'Rogue River', '46015', 'PORO3', '97444', 
		'9431011', null,'46015 - PORT ORFORD',	'PORO3 - PORT ORFORD',	
		'ROGUE RIVER',	'Gold Beach, OR', 'https://embed.windy.com/embed2.html?lat=42.179&lon=-124.542&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null, 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KMFR.html');
		
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, wave_source_id_2,
		wave_source_name_2, forecast_source) 
values
	('siuslaw-river', 'Siuslaw River', '46229', '46098', '97439', 
		'9434132', null,'46229 - UMPQUA OFFSHORE',	'46098 - WALDPORT OFFSHORE',	'SIUSLAW RIVER ENTRANCE',
		'Florence, OR', 'https://embed.windy.com/embed2.html?lat=43.808&lon=-124.303&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', null, '46050', '46050 - STONEWALL BANK', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KMFR.html');
		
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, wave_source_id_2,
		wave_source_name_2, forecast_source) 
values
	('tillamook-bay', 'Tillamook Bay', '46248', null, '97118', 
		'9437585', 'PCT1096','46248 - ASTORIA CANYON',	null,	'NORTH JETTY',
		'Garibaldi, OR', 'https://embed.windy.com/embed2.html?lat=45.542&lon=-124.016&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'TILLAMOOK BAY ENTRANCE', '46050', '46050 - STONEWALL BANK', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KPQR.html');

insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('umpqua-river', 'Umpqua River', '46229', '46098', '97467', 
		'9433445', 'PCT1066','46229 - UMPQUA OFFSHORE',	'46098 - WALDPORT OFFSHORE',	'UMPQUA RIVER ENTRANCE',
		'Winchester Bay, OR', 'https://embed.windy.com/embed2.html?lat=43.808&lon=-124.303&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'UMPQUA RIVER ENTRANCE', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KMFR.html');
	
insert into stations 
	(station_id, station_name, wave_source_id, 
		wind_source_id, weather_source_id, tide_source_id, 
		current_source_id, wave_source_name, wind_source_name, tide_source_name,
		city, radar_source, time_zone, current_source_name, forecast_source) 
values
	('yaquina-bay', 'Yaquina Bay', '46050', '46050', '97365', 
		'9435380', 'PCT1076','46050 - STONEWALL BANK',	'46050 - STONEWALL BANK',
		'SOUTHBEACH',	'Newport, OR', 'https://embed.windy.com/embed2.html?lat=44.645&lon=-124.176&width=380&height=325&zoom=8&level=surface&overlay=radar&product=radar&calendar=now&type=map&location=coordinates&metricWind=kt&metricTemp=%C2%B0F&radarRange=-1',
		'America/Los_Angeles', 'YAQUINA BAY ENTRANCE', 'https://www.ndbc.noaa.gov/data/Forecasts/FZUS56.KPQR.html');
		