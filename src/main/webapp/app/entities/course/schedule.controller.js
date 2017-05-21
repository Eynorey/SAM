(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('ScheduleController', ScheduleController);

    ScheduleController.$inject = ['$state', 'Course', 'ParseLinks', 'AlertService'];

    function ScheduleController($state, Course, ParseLinks, AlertService) {

        var vm = this;

        vm.transition = transition;

        loadAll();

        function loadAll () {
            Course.query({
                sort: ['start,asc', 'id']
            }, onSuccess, onError);

            function sort() {
                var result = [vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc')];
                if (vm.predicate !== 'id') {
                    result.push('id');
                }
                return result;
            }
            function onSuccess(data, headers) {
                //implement filter logic
                vm.totalItems = headers('X-Total-Count');
                vm.queryCount = vm.totalItems;
                vm.courses = data;
            }
            function onError(error) {
                AlertService.error(error.data.message);
            }
        }

        function transition() {
            $state.transitionTo($state.$current, {
                page: vm.page,
                sort: vm.predicate + ',' + (vm.reverse ? 'asc' : 'desc'),
                search: vm.currentSearch
            });
        }

    }
})();
