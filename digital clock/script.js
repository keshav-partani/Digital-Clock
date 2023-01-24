let dd = document.getElementById("dd")
let mm = document.getElementById("mm")
let yy = document.getElementById("yy")
let hour = document.getElementById("hour")
let min = document.getElementById("min")
let sec = document.getElementById("sec")

setInterval(function(){
  let a = new Date()
  dd.innerHTML = a.getDate();
  mm.innerHTML = a.toLocaleDateString('en-US', { month: '2-digit' });;
  yy.innerHTML = a.getFullYear();
  hour.innerHTML = a.getHours();
  min.innerHTML = a.getMinutes();
  sec.innerHTML = a.getSeconds();
}, 10);