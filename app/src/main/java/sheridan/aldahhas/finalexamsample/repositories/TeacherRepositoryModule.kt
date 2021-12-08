package sheridan.aldahhas.finalexamsample.repositories

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class TeacherRepositoryModule {

    @Singleton
    @Binds
    abstract fun bindTeacherRepository(repository: TeacherRepository): TeacherRepository
}