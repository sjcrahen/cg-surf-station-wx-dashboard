(function() {
	const dropdownContent = document.querySelector('.dropdown-content');
	const overlay = document.querySelector('.overlay');

	window.addEventListener('click', hideDropMenu);
	document.querySelector('#drop-btn').addEventListener('click', toggleDropdown);
	
	function toggleDropdown() {
		dropdownContent.scrollTop = 0;
		dropdownContent.classList.toggle('show');
		overlay.classList.toggle('show');
	}
	
	function hideDropMenu(event) {
		if (!event.target.matches('.dropbtn') && !event.target.matches('.dropdown-item')) {
			dropdownContent.classList.remove('show');
			overlay.classList.remove('show');
		}
	}
	
	window.setTimeout(function () {
		window.location.reload();
	}, 180_000);
})();