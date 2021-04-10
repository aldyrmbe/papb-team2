# Food Recipe App

**Food Recipe App** is an android application that shows recipes recommendation, detailed and categorized recipes, and promotional food from external source. This application use [themealdb](https://www.themealdb.com)
 as an external API.
 
Food Recipe Lifecycle overview:
* [onCreate()](https://developer.android.com/guide/components/activities/activity-lifecycle#oncreate): This method loads the splash screen when opening the app, set the user interface layout for HomeActivity, get meals and categories from API on HomeActivity, get data from intent to DetailActivity, and put the name of the meal name from the data intent to DetailPresenter.
* [onResume()](https://developer.android.com/guide/components/activities/activity-lifecycle#onresume): Show ads pop up from three random ads
* [onDestroy()](https://developer.android.com/reference/android/app/Activity#onDestroy()): Show exit app toaster

## Installation
Clone this repository to your local machine

```bash
git clone git@github.com:aldyrmbe/papb-team2.git
```

## Features
This android app lets you:
* View current recipe recommendation
* Find a specific food recipe
* Browse and explore lots of food categories 
* View detailed information about the recipe, such as instruction, ingredients, youtube video link, and other external link.
  
## Permissions
This application requires full network access.

## Maintainers
This project is maintained by Team 2 of Pengembangan Aplikasi Piranti Bergerak subject, consist of:
* [Mhd Rizaldy Andrian Rambe](https://github.com/aldyrmbe)
* [Adib Wirawan P](https://github.com/Siradrawanp)
* [Virginia Putri Mori](https://github.com/virginiaritonga)
* [Fajar Ryan Akhra](https://github.com/ryanakhra2)

## Contributing
We currently only accept contributions from collaborators.

## Support
If you need assistance, please contact one of the following emails, with the subject "Ask - Food Recipe App":
1. mhdrizaldy@mail.ugm.ac.id (Aldy)
2. adib.w.p@mail.ugm.ac.id (Adib)
3. virginia.p.m@mail.ugm.ac.id (Virginia)
4. fajar.ryan.akhra@mail.ugm.ac.id (Ryan)

## License
[MIT](https://choosealicense.com/licenses/mit/)
