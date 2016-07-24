var gulp = require('gulp'),
    imagemin = require('gulp-imagemin'),
    clean = require('gulp-clean'),
    uglify = require('gulp-uglify'),
    usemin = require('gulp-usemin'),
    cssmin = require('gulp-cssmin');

gulp.task('default',['clean'],function(){
  gulp.start('build-img','usemin');
});

gulp.task('build-img', function() {
  gulp.src('src/img/**/*')
    .pipe(imagemin())
    .pipe(gulp.dest('dist/img'));
});

gulp.task('clean',function() {
  return gulp.src('dist')
            .pipe(clean());
});

gulp.task('usemin', function() {
  return gulp.src('src/**/*.html')
    .pipe(usemin({
      js: [uglify],
      css: [cssmin]
    }))
    .pipe(gulp.dest('dist'));
});
