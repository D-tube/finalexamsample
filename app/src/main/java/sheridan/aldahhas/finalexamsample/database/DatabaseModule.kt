package sheridan.aldahhas.finalexamsample.database

import android.content.Context
import android.util.Log
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    private const val TAG = "DataBassModule"

    @Provides
    fun provideTeacherDao(database: TeacherDatabase): TeacherDao {
        Log.d(TAG, "provideTeacherDao: the TeacherDao object is returned")
        return database.teacherDao()
    }

    @Singleton
    @Provides
    fun provideTeacherDatabase(@ApplicationContext context: Context): TeacherDatabase{
        Log.d(TAG, "provideTeacherDatabase: the database object is created")
        return  Room.databaseBuilder(
            context,
            TeacherDatabase::class.java,
            "teacher_database"
        ).build()
    }
}