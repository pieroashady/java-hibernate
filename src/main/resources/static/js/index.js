console.log('fired');

const addLeadingZero = (date) => {
  return ('0' + date).slice(-2);
};

const clock = () => {
  const date = new Date();

  let hours = addLeadingZero(date.getHours());
  let minutes = addLeadingZero(date.getMinutes());
  let seconds = addLeadingZero(date.getSeconds());

  document.getElementById('show-date').innerHTML = `${hours}:${minutes}:${seconds}`;

  setTimeout(clock, 1000);
};

clock();
