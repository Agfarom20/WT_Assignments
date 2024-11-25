let timeInterval;

document.body.addEventListener('click', function () {
    document.body.style.backgroundColor = '#e6e6fa'; 
});

document.getElementById('timeButton').addEventListener('click', function () {
    if (!timeInterval) {
        timeInterval = setInterval(function () {
            const timeDisplay = document.getElementById('timeDisplay');
            timeDisplay.textContent = new Date().toLocaleTimeString();
        }, 1000);
    }
});


document.getElementById('hoverText').addEventListener('mouseover', function () {
    this.textContent = 'Groove on!';
});

document.getElementById('hoverText').addEventListener('mouseout', function () {
    this.textContent = 'Hover to find the beat!';
});
