(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('ScheduleController', ScheduleController);

    ScheduleController.$inject = ['$state', 'Course', 'ParseLinks', 'AlertService', 'Principal'];

    function ScheduleController($state, Course, ParseLinks, AlertService, Principal) {

        var vm = this;

        Course.query({
            sort: ['start,asc', 'id']
        }, onSuccess, onError);

        function onSuccess(data, headers) {
            vm.courses = [];
            for (var i = 0; i < data.length; i++) {
                Course.get({id : data[i].id}).$promise.then(function(course) {
                    if(course.attendees.find(function(user){
                            return user.login === vm.currentUser.login;
                        })) {
                        vm.courses.push(course);
                    }
                });
            }
        }

        function onError(error) {
            AlertService.error(error.data.message);
        }

        /**
         * Store the "currentUser" in a separate variable, and not in the shared "account" variable.
         */
        var copyAccount = function (account) {
            return {
                id: account.id,
                login: account.login,
                firstName: account.firstName,
                lastName: account.lastName,
                email: account.email,
                activated: account.activated,
                langKey: account.langKey,
                imageUrl: account.imageUrl,
                resetKey: account.resetKey,
                resetDate: account.resetDate
            };
        };

        Principal.identity().then(function(account) {
            vm.currentUser = copyAccount(account);
        });
    }
})();
