package com.backend.api.springbootkotlin.services

import com.backend.api.springbootkotlin.model.Courses

interface CourseService {
    fun getCourse(): List<Courses>
    fun getCourseWithID(courseID: Int): Courses
    fun addCourse(courses: Courses): Courses
}