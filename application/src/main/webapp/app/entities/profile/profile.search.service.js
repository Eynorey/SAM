(function() {
    'use strict';

    angular
        .module('samApp')
        .factory('ProfileSearch', ProfileSearch);

    ProfileSearch.$inject = ['$resource'];

    function ProfileSearch($resource) {
        var resourceUrl =  'api/_search/profiles/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
