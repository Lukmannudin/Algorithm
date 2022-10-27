//// pseudoclass for View Binding class
//// class ItemEpisodeBinding(val titleView: TextView, val downloadButton: Button, val progressView: ProgressBar, val lytImage: ImageView)
//
//class EpisodeViewHolder(val binding: ItemEpisodeBinding): RecyclerView.ViewHolder(binding.root){
//
//    fun bind(episode: Episode, downloadListener: (Episode) -> Unit){
//        with(binding) {
//            titleView.text = episode.title
//
//            downloadButton.isVisible = (episode.downloadStatus == NOT_DOWNLOADED)
//            progressView.isVisible = (episode.downloadStatus == DOWNLOADING)
//
//            downloadButton.setOnClickListener {
//                downloadListener.invoke(episode)
//            }
//        }
//
//
//        Glide.with(context)
//            .load(episode.thumbnailUrl)
//            .into(binding.lytImage)
//    }
//}
//
//class EpisodeAdapter(private val episodes: List): RecyclerView.Adapter() {
//
//    private var onVideoDownloadListener: (Episode) -> Unit = { onDonwloadEpisode ->
//        val index = episodes.indexOfFirst { episode -> episode.id ==  onDonwloadEpisode.id }
//        if (index >= 0) {
//            Thread {
//               onVideoDownload(index)
//            }.start()
//        }
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodeViewHolder {
//        return EpisodeViewHolder(ItemEpisodeBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//    }
//
//    override fun onBindViewHolder(holder: EpisodeViewHolder, position: Int) {
//        holder.bind(episodes[position], onVideoDownloadListener)
//    }
//
//    override fun getItemCount(): Int = episodes.size
//
//    private fun onVideoDownload(index: Int) {
//        try {
//            episodes[index].downloadStatus = DownloadStatus.DOWNLOADING
//            notifyItemChanged(index)
//            VidioSDK.downloadEpisode(episodeId)
//            episodes[index].downloadStatus = DownloadStatus.DOWNLOAD_FINISH
//            notifyItemChanged(index)
//        } catch (e: Exception) {
//            episodes[index].downloadStatus = DownloadStatus.NOT_DOWNLOADED
//            notifyItemChanged(index)
//        }
//    }
//}
//
//data class Episode(
//    val id: Long,
//    val title: String,
//    val duration: String,
//    val thumbnailUrl: String,
//    val description: String,
//    val isFree: Boolean,
//    var downloadStatus: DownloadStatus
//)
//
//enum class DownloadStatus {
//    NOT_DOWNLOADED,
//    DOWNLOADING,
//    DOWNLOAD_FINISH
//}