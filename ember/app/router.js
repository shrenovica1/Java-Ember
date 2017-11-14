import Ember from 'ember';
import config from './config/environment';

const Router = Ember.Router.extend({
  location: config.locationType,
  rootURL: config.rootURL
});

Router.map(function() {
  this.route('scientists');
  this.route('programmers');
  this.route('singup');
  this.route('singin');
  this.route('home');
  this.route('popular-restaurants');

  this.route('restaurant');
  this.route('location');
  this.route('reservation');
});

export default Router;

