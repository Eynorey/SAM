(function() {
    'use strict';

    angular
        .module('samApp')
        .controller('CourseDetailController', CourseDetailController);

    CourseDetailController.$inject = ['$scope', '$rootScope', '$stateParams', 'previousState', 'entity', 'Course', 'Skill', 'User', 'Principal'];

    function CourseDetailController($scope, $rootScope, $stateParams, previousState, entity, Course, Skill, User, Principal) {
        var vm = this;

        vm.course = entity;
        vm.currentUser = null;
        vm.previousState = previousState.name;

        var unsubscribe = $rootScope.$on('samApp:courseUpdate', function(event, result) {
            vm.course = result;
        });
        $scope.$on('$destroy', unsubscribe);

        vm.book = function () {
            vm.isSaving = true;
            vm.course.attendees.push(vm.currentUser);
            Course.update(vm.course, onSaveSuccess, onSaveError);
        };

        vm.cancel = function () {
            vm.isSaving = true;
            vm.course.attendees.pop(vm.currentUser);
            Course.update(vm.course, onSaveSuccess, onSaveError);
        };

        function onSaveSuccess (result) {
            vm.isSaving = false;
        }


        function onSaveError () {
            vm.isSaving = false;
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

        vm.alreadyBooked = function () {
            if(vm.course.attendees.find(function(user){
                return user.login === vm.currentUser.login;
            })) {
                return true;
            }
            return false;
        }
    }
})();
