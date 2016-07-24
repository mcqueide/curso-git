var gulp = require('gulp'),
    imagemin = require('gulp-imagemin'),
    clean = require('gulp-clean');

gulp.task('build-img',['clean'], function() {
  gulp.src('src/img/**/*')
    .pipe(imagemin())
    .pipe(gulp.dest('dist/img'));
});

gulp.task('clean',function() {
  return gulp.src('dist')
            .pipe(clean());
});
