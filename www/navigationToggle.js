var navigationToggle = {
    show: function() {
        cordova.exec(
            function() {
                alert('shown');
            }, function(error) {
                alert(error);
            },
            'NagivationToggle', 'show', []);
    },
    hide: function() {
        cordova.exec(
            function() {
                alert('hidden');
            }, function(error) {
                alert(error);
            },
            'NagivationToggle', 'hide', []);
    }
};

module.exports = navigationToggle;