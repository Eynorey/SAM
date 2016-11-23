(function() {
    'use strict';

    angular
        .module('samApp')
        .factory('CourseSearch', CourseSearch);

    CourseSearch.$inject = ['$resource'];

    function CourseSearch($resource) {
        var resourceUrl =  'api/_search/courses/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true}
        });
    }
})();
