package com.anahitavakoli.apps.nightell.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity
data class Audio (
        @PrimaryKey
        @ColumnInfo("id")
        @SerializedName ("id")
        val id: String,
        @ColumnInfo("cat_id")
        @SerializedName ("cat_id")
        val catId: String,
        @ColumnInfo("mp3_type")
        @SerializedName ("mp3_type")
        val mp3Type: String,
        @ColumnInfo("mp3_title")
        @SerializedName ("mp3_title")
        val mp3Title: String,
        @ColumnInfo("mp3_url")
        @SerializedName ("mp3_url")
        val mp3Url: String,
        @ColumnInfo("mp3_thumbnail_b")
        @SerializedName ("mp3_thumbnail_b")
        val mp3ThumbnailB: String,
        @ColumnInfo("mp3_thumbnail_s")
        @SerializedName ("mp3_thumbnail_s")
        val mp3ThumbnailS: String,
        @ColumnInfo("mp3_duration")
        @SerializedName ("mp3_duration")
        val mp3Duration: String,
        @ColumnInfo("mp3_artist")
        @SerializedName ("mp3_artist")
        val mp3Artist: String,
        @ColumnInfo("mp3_description")
        @SerializedName ("mp3_description")
        val mp3Description: String,
        @ColumnInfo("total_rate")
        @SerializedName ("total_rate")
        val totalRate: String,
        @ColumnInfo("rate_avg")
        @SerializedName ("rate_avg")
        val rateAvg: String,
        @ColumnInfo("total_views")
        @SerializedName ("total_views")
        val totalViews: String,
        @ColumnInfo("total_download")
        @SerializedName ("total_download")
        val totalDownload: String,
        @ColumnInfo("cid")
        @SerializedName ("cid")
        val cId: String,
        @ColumnInfo("category_name")
        @SerializedName ("category_name")
        val categoryName: String,
        @ColumnInfo("category_image")
        @SerializedName ("category_image")
        val categoryImage: String,
        @ColumnInfo("category_image_thumb")
        @SerializedName ("category_image_thumb")
        val categoryImageThumb: String
) : Parcelable