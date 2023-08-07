
$(document).ready(function () {
  var toggleTimeout;

  // When  mouse hovers over Picture1 or P2
  $(".P1, .P2").hover(function () {
    // display the book now button
    $(".BookNowB1").slideDown();
    // Clear any existing timeout 
    clearTimeout(toggleTimeout);
  }, function () {
    // hide the button after a set amount of time
    toggleTimeout = setTimeout(function () {
      $(".BookNowB1").slideUp();
    }, 333);
  });

  // When mouse hovers over the Book Now button
  $(".BookNowB1").hover(function () {
    // decrease picture opacity
    $(".P1, .P2").css("opacity", "0.5");
    clearTimeout(toggleTimeout);
  }, function () {
    $(".P1, .P2").css("opacity", "1");

    // hide the button after a set amount of time
    toggleTimeout = setTimeout(function () {
      $(".BookNowB1").slideUp();
    }, 333);
  });
  
  
});

// event listeners for the tabs
document.addEventListener("DOMContentLoaded", function() {

    const roomsTab = document.querySelector('a[href="rooms.html"]');
    const AmenitiesTab = document.querySelector('a[href="amenities.html"]');
    const IndexTab = document.querySelector('a[href="index.html"]');
    const bookingTab = document.querySelector('a[href="booking.html"]');
  
    roomsTab.addEventListener("click", function(event) {

      });
    AmenitiesTab.addEventListener("click", function(event) {

      });

    IndexTab.addEventListener("click", function(event) {
       
      });
    bookingTab.addEventListener("click", function(event) {

  });})