      // Your Client ID can be retrieved from your project in the Google
      // Developer Console, https://console.developers.google.com
      var CLIENT_ID = '302920458547-5huq44smkpov0ifffp3hur0muq65m6g4.apps.googleusercontent.com';

      var SCOPES = ['https://www.googleapis.com/auth/plus.login'];

      /**
       * Check if current user has authorized this application.
       */
      function checkAuth() {
        gapi.auth.authorize(
          {
            'client_id': CLIENT_ID,
            'scope': SCOPES.join(' '),
            'immediate': true
          }, handleAuthResult);
      }

      /**
       * Handle response from authorization server.
       *
       * @param {Object} authResult Authorization result.
       */
      function handleAuthResult(authResult) {
        var authorizeDiv = document.getElementById('authorize-div-g');
        if (authResult && !authResult.error) {
          // Hide auth UI, then load client library.
          authorizeDiv.style.display = 'none';
          loadGmailApi();
        } else {
          // Show auth UI, allowing the user to initiate authorization by
          // clicking authorize button.
        //  authorizeDiv.style.display = 'inline';
        }
      }

      /**
       * Initiate auth flow in response to user clicking authorize button.
       *
       * @param {Event} event Button click event.
       */
      function handleAuthClick(event) {
        gapi.auth.authorize(
          {client_id: CLIENT_ID, scope: SCOPES, immediate: false},
          handleAuthResult);
        return false;
      }

      /**
       * Load Gmail API client library. List labels once client library
       * is loaded.
       */
      function loadGmailApi() {
       // gapi.client.load('gmail', 'v1', getmessage);
       gapi.client.load('gmail', 'v1', listLabels);
       //gapi.client.load('gmail', 'v1', listname);
      }

      /**
       * Print all Labels in the authorized user's inbox. If no labels
       * are found an appropriate message is printed.
       */
      function listLabels() {
        var request = gapi.client.gmail.users.getProfile({
          'userId': 'me'
        });
        request.execute(function(resp) {
        	
        	alert(resp.emailAddress);
        	
        });
      }
      