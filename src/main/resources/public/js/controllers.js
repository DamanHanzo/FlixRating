angular.module('app.controllers', []).controller('FlixRatingListController', function($scope, $state, popupService, $window, FlixRating) {
  $scope.flixRatings = FlixRating.query(); //fetch all shipwrecks. Issues a GET to /api/vi/shipwrecks

  $scope.deleteFlixRating = function(flixRating) { // Delete a Shipwreck. Issues a DELETE to /api/v1/shipwrecks/:id
    if (popupService.showPopup('Really delete this?')) {
      flixRating.$delete(function() {
        $scope.flixRatings = FlixRating.query();
        $state.go('flixRating');
      });
    }
  };
}).controller('FlixRatingViewController', function($scope, $stateParams, FlixRating) {
  $scope.flixRating = FlixRating.get({ id: $stateParams.id }); //Get a single shipwreck.Issues a GET to /api/v1/shipwrecks/:id
}).controller('FlixRatingCreateController', function($scope, $state, $stateParams, FlixRating) {
  $scope.flixRating = new FlixRating();  //create new shipwreck instance. Properties will be set via ng-model on UI

  $scope.addFlixRating = function() { //create a new shipwreck. Issues a POST to /api/v1/shipwrecks
    $scope.flixRating.$save(function() {
      $state.go('flixRating'); // on success go back to the list i.e. shipwrecks state.
    });
  };
}).controller('FlixRatingEditController', function($scope, $state, $stateParams, FlixRating) {
  $scope.updateFlixRating = function() { //Update the edited shipwreck. Issues a PUT to /api/v1/shipwrecks/:id
    $scope.flixRating.$update(function() {
      $state.go('flixRating'); // on success go back to the list i.e. shipwrecks state.
    });
  };

  $scope.loadFlixRating = function() { //Issues a GET request to /api/v1/shipwrecks/:id to get a shipwreck to update
    $scope.flixRating = FlixRating.get({ id: $stateParams.id });
  };

  $scope.loadFlixRating(); // Load a shipwreck which can be edited on UI
});
