pjs.addSuite({
    // single URL or array
    url: 'www.brown.edu/Student_Services/Food_Services/eateries/refectory_menu.php',
    // single function or array, evaluated in the client
    scraper: function() {
        return $('').text();
    }
});
