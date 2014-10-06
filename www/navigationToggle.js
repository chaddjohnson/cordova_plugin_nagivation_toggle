var navigationToggle = {
    show: function() {
        cordova.exec(
            function() {
                alert('shown');
            }, function(error) {
                alert('error showing');
                alert(error);
            },
            'NagivationToggle', 'show', []);
    },
    hide: function() {
        cordova.exec(
            function() {
                alert('hidden');
            }, function(error) {
                alert('error hiding');
                alert(error);
            },
            'NagivationToggle', 'hide', []);
    }
};

module.exports = navigationToggle;