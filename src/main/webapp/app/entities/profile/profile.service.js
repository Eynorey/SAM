(function() {
    'use strict';
    angular
        .module('samApp')
        .factory('Profile', Profile);

    Profile.$inject = ['$resource', 'DateUtils'];

    function Profile ($resource, DateUtils) {
        var resourceUrl =  'api/profiles/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    if (data) {
                        data = angular.fromJson(data);
                        data.birthday = DateUtils.convertDateTimeFromServer(data.birthday);
                    }
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
