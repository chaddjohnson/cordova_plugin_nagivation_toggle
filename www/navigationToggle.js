var navigationToggle = {
    show: function() {
        cordova.exec(
            function() {
                // Success; do nothing
            }, function(error) {
                alert(error);
            },
            'NavigationToggle', 'show', []);
    },
    hide: function() {
        cordova.exec(
            function() {
                // Success; do nothing
            }, function(error) {
                alert(error);
            },
            'NavigationToggle', 'hide', []);
    },
    toggle: function() {
        cordova.exec(
            function() {
                // Success; do nothing
            }, function(error) {
                alert(error);
            },
            'NavigationToggle', 'toggle', []);
    }
};

module.exports = navigationToggle;