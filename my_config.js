pjs.addSuite({
    // single URL or array
    url: 'http://brownrec.com/aquatics/hours',
    // single function or array, evaluated in the client
    scraper: function() {
        return $('header#site-header').text();
    }
});