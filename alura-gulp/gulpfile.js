var gulp = require('gulp'),
    imagemin = require('gulp-imagemin'),
    clean = require('gulp-clean'),
    concat = require('gulp-concat'),
    htmlReplace = require('gulp-html-replace');

gulp.task('default',['copy'],function(){
  gulp.start('build-img','build-html','build-js','build-css');
});

gulp.task('copy', ['clean'], function() {
    return gulp.src('src/**/*')
        .pipe(gulp.dest('dist'));
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

gulp.task('build-js', function() {
    return gulp.src(['src/js/jquery.js',
              'src/js/home.js',
              'src/js/ativa-filtro.js'])
            .pipe(concat('all.js'))
            .pipe(gulp.dest('dist/js'));
});

gulp.task('build-css',function() {
  return gulp.src(["src/css/reset.css",
                "src/css/estilos.css",
                "src/css/mobile.css"])
              .pipe(concat('all.css'))
              .pipe(gulp.dest('dist/css'));
});

gulp.task('build-html', function() {
  return gulp.src('src/**/*.html')
    .pipe(htmlReplace({
            'js': 'js/all.js',
            'css': 'css/all.css',
    }))
    .pipe(gulp.dest('dist/'));
});
