(function() {
	const dropdownContent = document.querySelector('.dropdown-content');

	window.addEventListener('click', hideDropMenu);
	document.querySelector('#drop-btn').addEventListener('click', addClassShow);
	
	function addClassShow() {
		document.querySelector('#drop').classList.toggle('show');
	}
	
	function hideDropMenu(event) {
		if (!event.target.matches('.dropbtn')) {
			if (dropdownContent.classList.contains('show')) {
				dropdownContent.classList.remove('show');
			}
		}
	}

	window.setTimeout(function () {
		window.location.reload();
	}, 180000);
}());