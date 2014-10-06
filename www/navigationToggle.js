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
    },
    toggle: function() {
        cordova.exec(
            function() {
                alert('toggle');
            }, function(error) {
                alert(error);
            },
            'NavigationToggle', 'toggle', []);
    }
};

module.exports = navigationToggle;