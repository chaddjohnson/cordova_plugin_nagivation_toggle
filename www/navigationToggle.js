var navigationToggle = {
    show: function() {
        cordova.exec(
            function() {
                alert('shown');
            }, function(error) {
                alert(error);
            },
            'NavigationToggle', 'show', []);
    },
    hide: function() {
        cordova.exec(
            function() {
                alert('hidden');
            }, function(error) {
                alert(error);
            },
            'NavigationToggle', 'hide', []);
    }
};

module.exports = navigationToggle;