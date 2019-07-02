package htPackage
import java.util.concurrent.TimeUnit
import java.util.function.Function

import org.openqa.selenium.NotFoundException
import org.openqa.selenium.support.ui.FluentWait

import com.kms.katalon.core.annotation.Keyword


public class FileDownloaded {

	@Keyword
	def deleteFile(String downloadPath, String fileName) {
		String pathName = downloadPath+fileName;
		File file = new File(pathName);
		if (file.exists()) {
			file.delete();
		}
	}

	@Keyword
	public void waitUntilFileDownloaded(String downloadLocation, String fileName, int waitTimeOutInSeconds, int checkExistsEverySecond) {
		File f = new File(downloadLocation + fileName)

		FluentWait<File> wait = new FluentWait<File>(f)
				.withTimeout(waitTimeOutInSeconds, TimeUnit.SECONDS)
				.pollingEvery(checkExistsEverySecond, TimeUnit.SECONDS)
				.ignoring(NotFoundException.class)

		wait.until(new Function<File, Boolean>() {
					@Override
					public Boolean apply(File file) {
						if (file.exists()) return true;

						throw new NotFoundException("File is not downloaded successfully");
					}
				});
	}
}