var navigationToggle = {
    show: function() {
        cordova.exec(
            function() {
                alert('shown');
            }, function() {
                alert('error showing');
            },
            'NagivationToggle', 'show', []);
    },
    hide: function() {
        cordova.exec(
            function() {
                alert('hidden');
            }, function() {
                alert('error hiding');
            },
            'NagivationToggle', 'hide', []);
    }
};

module.exports = navigationToggle;