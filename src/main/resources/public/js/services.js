angular.module('app.services', []).factory('FlixRating', function($resource) {
  return $resource('/api/v1/flixRatings/:id', { id: '@id' }, {
    update: {
      method: 'PUT'
    }
  });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
