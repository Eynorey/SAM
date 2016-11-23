'use strict';

describe('Controller Tests', function() {

    describe('Profile Management Detail Controller', function() {
        var $scope, $rootScope;
        var MockEntity, MockPreviousState, MockProfile, MockUser, MockCourse, MockSkill;
        var createController;

        beforeEach(inject(function($injector) {
            $rootScope = $injector.get('$rootScope');
            $scope = $rootScope.$new();
            MockEntity = jasmine.createSpy('MockEntity');
            MockPreviousState = jasmine.createSpy('MockPreviousState');
            MockProfile = jasmine.createSpy('MockProfile');
            MockUser = jasmine.createSpy('MockUser');
            MockCourse = jasmine.createSpy('MockCourse');
            MockSkill = jasmine.createSpy('MockSkill');
            

            var locals = {
                '$scope': $scope,
                '$rootScope': $rootScope,
                'entity': MockEntity,
                'previousState': MockPreviousState,
                'Profile': MockProfile,
                'User': MockUser,
                'Course': MockCourse,
                'Skill': MockSkill
            };
            createController = function() {
                $injector.get('$controller')("ProfileDetailController", locals);
            };
        }));


        describe('Root Scope Listening', function() {
            it('Unregisters root scope listener upon scope destruction', function() {
                var eventType = 'samApp:profileUpdate';

                createController();
                expect($rootScope.$$listenerCount[eventType]).toEqual(1);

                $scope.$destroy();
                expect($rootScope.$$listenerCount[eventType]).toBeUndefined();
            });
        });
    });

});
