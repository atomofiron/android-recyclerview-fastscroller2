# FastScroller2
This is a fork of the `RecyclerView`'s default `FastScroller` from `androidx.recyclerview:recyclerview:1.3.2`

https://github.com/user-attachments/assets/c483662d-190e-43cf-96b2-a093b1de7375

## Comparison

| Feature | FastScroller | FastScroller2 |
| - | - | - |
| RTL support | ✅ | ✅ |
| dragging | ✅ | ✅ |
| drawable customization | ✅ | ✅ |
| full customization | ❌ | ✅ |
| placement on the start | ❌ | ✅ |
| taking into account paddings | ❌ | ✅ |
| specifying the min length of thumb | ❌ | ✅ |
| specifying the dragging area size | ❌ | ✅ |
| dragging area in debug mode | ❌ | ✅ |
| drawing and dragging callbacks | ❌ | ✅ |
| ability to scroll to the edge | ❌ | ✅ |

## How to get

Switch to the `main` branch and manually download `FastScroller2.kt` via web browser, or add repository as submodule:
```zsh
cd /path/to/your/project/app/src/main/kotlin/ # or java/
git submodule add git@github.com:atomofiron/android-recyclerview-fastscroller2.git fastscroller2
cd fastscroller2
git checkout main # FastScroller2.kt and license files only
# later keep it up to date by running:
git fetch && git pull # in /path/to/your/project/app/src/main/kotlin/fastscroller2/
```

### Help

```zsh
git help submodule
```

## How to use

```kotlin
val fastScroller2 = FastScroller2(
    recyclerView,
    ContextCompat.getDrawable(this, R.drawable.scroll_thumb) as StateListDrawable,
    ContextCompat.getDrawable(this, R.drawable.scroll_track) as Drawable,
    ContextCompat.getDrawable(this, R.drawable.scroll_thumb) as StateListDrawable,
    ContextCompat.getDrawable(this, R.drawable.scroll_track) as Drawable,
    resources.getDimensionPixelSize(R.dimen.fastscroll_thickness), // 6dp
    resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), // 50dp
    resources.getDimensionPixelSize(R.dimen.fastscroll_area), // 16dp
    resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_length), // 56dp
    inTheEnd = false,
)
```
### also you can **replace** the RecyclerView:
```kotlin
fastScroller2.attachToRecyclerView(otherRecyclerView)
```
